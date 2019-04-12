<template>
  <div class="json-editor">
    <textarea ref="textarea" />
    </div>
</template>

<script>
import CodeMirror from 'codemirror'
import 'codemirror/addon/lint/lint.css'
import 'codemirror/lib/codemirror.css'
import 'codemirror/theme/rubyblue.css'
import 'codemirror/mode/javascript/javascript'
export default {
  name: 'CodeMirror',
  /* eslint-disable vue/require-prop-types */
  props: {
    newList: {
      type: Object,
    }
  },
  data () {
    return {
      jsonShow: true
    }
  },
  watch: {
    newList (value) {
      const editorValue = this.jsonShow.getValue()
      if (value !== editorValue) {
        this.jsonShow.setValue(JSON.stringify(this.newList, null, 2))
      }
    }
  },
  mounted () {
    this.jsonShow = CodeMirror.fromTextArea(this.$refs.textarea, {
      lineNumbers: true,
      tabWidth: 4,
      readOnly: 'nocursor', // 只读模式   nocursor 不显示光标
      mode: 'application/json', // 设置编译器编程语言关联内容
      gutters: ['CodeMirror-lint-markers'],
      //theme: 'rubyblue',  主题，需要引入对应包
      smartIndent: true, // 自动缩进
      lint: false
    })
    this.jsonShow.setValue(JSON.stringify(this.value, null, 2))
    this.jsonShow.on('change', cm => {
      this.$emit('changed', cm.getValue())
      this.$emit('input', cm.getValue())
    })
  },
  methods: {
    getValue () {
      return this.jsonShow.getValue()
    }
  }
}
</script>

<style scoped>
.json-editor {
  height: 100%;
  position: relative;
}
.json-editor .CodeMirror {
  height: auto;
  min-height: 200px;
}
.json-editor .CodeMirror-scroll {
  min-height: 200px;
}
.json-editor .cm-s-rubyblue span.cm-string {
  color: #f08047;
}
</style>
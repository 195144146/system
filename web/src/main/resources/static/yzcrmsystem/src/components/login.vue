<template>
    <Form ref="user" :model="user" :rules="ruleInline" inline>
      <FormItem prop="account">
        <Input type="text" v-model="user.account" placeholder="请输入账号">
          <Icon type="ios-person-outline" slot="prepend"></Icon>
        </Input>
      </FormItem>
      <FormItem prop="password">
        <Input type="password" v-model="user.password" placeholder="请输入密码" on-enter="submit">
          <Icon type="ios-locked-outline" slot="prepend"></Icon>
        </Input>
      </FormItem>
      <FormItem>
        <Button type="primary" @click="submit()">登录</Button>
      </FormItem>
    </Form>
</template>
<script>
export default {
  name: 'login',
  data () {
    return {
      user: {
        account: '',
        password: ''
      },
      ruleInline: {
        account: [
          {required: true, message: '账号为空', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码为空', trigger: 'blur'},
          {type: 'string', min: 6, message: '密码不得小于6位', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    submit () {
      this.$http.post('/api/user/getKey', {}).then(response => {
        console.info(response)
        if (response.result) {
        } else {
          this.$Message.info(response.errorMessage)
        }
      })
    }
  }
}
</script>

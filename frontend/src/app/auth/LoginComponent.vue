<template>
    <div>
    <div>
      <h2>Login</h2>
      <label for="email">E-mail:</label>
      <input v-model="email" type="text" />
      <label class="mt-3" for="password">Senha:</label>
      <input v-model="senha" type="password" />
      <button v-on:click="login">
        Login
      </button>
    </div>
  </div>
</template>

<script>
import service from './service'

export default {
  data () {
    return {
      email: null,
      senha: null
    }
  },
  methods: {
    login () {
      const credenciais = {
        email: this.email,
        senha: this.senha
      }

      service.login(credenciais).then(res => {
        if (res.data.token != null) {
          localStorage.setItem('token', res.data.token)
          this.$router.push('/')
        }
      })
    }
  }
}
</script>

<style>

</style>

<template>
  <div>
    <div class="d-flex justify-content-center">
      <Card style="width: 25em" class="mt-5">
        <template #header>
          <!-- <div class="flex justify-content-center mt-4">
            <img alt="logo" src="" style="width: 10em" />
          </div> -->
        </template>
        <template #content>
          <div class="text-center">
            <h4>LOGIN</h4>
          </div>
          <div class="formgrid grid p-fluid">
            <div class="field col-12 mt-2">
              <div class="p-inputgroup">
                <span class="p-inputgroup-addon">
                  <i class="pi pi-envelope"></i>
                </span>
                <InputText
                  v-model="email"
                  @input="v$.email.$touch()"
                  placeholder="E-mail"
                />
              </div>
              <small class="p-error" v-if="v$.email.$error"
                >E-mail é obrigatório</small
              >
            </div>
            <div class="field col-12 mt-2">
              <div class="p-inputgroup">
                <span class="p-inputgroup-addon">
                  <i class="pi pi-key"></i>
                </span>
                <InputText
                  v-model="senha"
                  type="password"
                  @input="v$.senha.$touch()"
                  placeholder="Senha"
                />
              </div>
              <small class="p-error" v-if="v$.senha.$error"
                >Senha é obrigatória</small
              >
            </div>
          </div>
          <div
            class="col-12 d-inline-flex flex-column justify-content-center mt-2"
          >
            <Button
              label="Entrar"
              icon="pi pi-check"
              @click="send"
              class="btnLogin"
            />
            <div class="mt-4 text-center">
              <strong>
                Não possui conta ?
                <router-link to="/cadastrar">Cadastrar</router-link></strong
              >
            </div>
          </div>
        </template>
      </Card>
    </div>
  </div>
</template>

<script>
import service from './service'
import useVuelidate from '@vuelidate/core'
import { required } from '@vuelidate/validators'

export default {
  setup () {
    return { v$: useVuelidate() }
  },
  data () {
    return {
      email: '',
      senha: ''
    }
  },
  validations () {
    return {
      email: { required },
      senha: { required }
    }
  },
  methods: {
    send () {
      this.v$.$touch()
      if (this.v$.$invalid) return
      this.$store.dispatch('addRequest')
      this.login()
    },

    login () {
      const credenciais = {
        email: this.email,
        senha: this.senha
      }

      service
        .login(credenciais)
        .then((res) => {
          if (res.data.token != null) {
            localStorage.setItem('id_usuario', res.data.id)
            localStorage.setItem('token', res.data.token)
            localStorage.setItem('usuario', res.data.usuario)
            this.$router.push('/')
          }
          this.$store.dispatch('removeRequest')
        })
        .catch((erro) => {
          this.$toast.add({
            severity: 'error',
            summary: 'Error',
            detail: `${erro.response.data.descricao}`,
            life: 3000
          })
          this.$store.dispatch('removeRequest')
        })
    }
  }
}
</script>

<style></style>

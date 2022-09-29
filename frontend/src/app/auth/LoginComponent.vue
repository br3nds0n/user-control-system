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
                <InputText v-model="email" placeholder="E-mail" />
              </div>
            </div>
            <div class="field col-12 mt-2">
              <div class="p-inputgroup">
                <span class="p-inputgroup-addon">
                  <i class="pi pi-key"></i>
                </span>
                <InputText v-model="senha" type="password" placeholder="Senha" />
              </div>
            </div>
          </div>
          <div class="col-12 d-inline-flex flex-column justify-content-center mt-2">
            <Button
              label="Entrar"
              icon="pi pi-check"
              v-on:click="login"
              class="btnLogin"
            />
            <div class="mt-4 text-center">
              <strong> Já possui conta ? <router-link to="/cadastrar">Cadastrar</router-link></strong>
            </div>
          </div>
        </template>
      </Card>
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

      this.$store.dispatch('addRequest')
      service.login(credenciais).then((res) => {
        if (res.data.token != null) {
          localStorage.setItem('token', res.data.token)
          this.$router.push('/')
        }
        this.$store.dispatch('removeRequest')
      })
    }
  }
}
</script>

<style></style>

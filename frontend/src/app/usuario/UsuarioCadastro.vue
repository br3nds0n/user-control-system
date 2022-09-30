<template>
  <div>
    <div class="d-flex justify-content-center">
      <Card style="width: 25em" class="mt-5">
        <template #content>
          <div class="text-center">
            <h4>CADASTRO</h4>
          </div>
          <div class="formgrid grid p-fluid">
            <div class="field col-12 mt-2">
              <div class="p-inputgroup">
                <span class="p-inputgroup-addon">
                  <i class="pi pi-user"></i>
                </span>
                <InputText
                  v-model="usuario"
                  @input="v$.usuario.$touch()"
                  placeholder="Usuário"
                />
              </div>
              <small class="p-error" v-if="v$.usuario.$error"
                >Usuário é obrigatório</small
              >
            </div>
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
                  <i class="pi pi-id-card"></i>
                </span>
                <InputText
                  v-model="cpf"
                  @input="v$.cpf.$touch()"
                  placeholder="CPF"
                />
              </div>
              <small class="p-error" v-if="v$.cpf.$error"
                >CPF é obrigatório</small
              >
            </div>
            <div class="field col-12 mt-2">
              <div class="p-inputgroup">
                <span class="p-inputgroup-addon">
                  <i class="pi pi-credit-card"></i>
                </span>
                <InputText
                  v-model="cep"
                  @input="v$.cep.$touch()"
                  placeholder="CEP"
                />
              </div>
              <small class="p-error" v-if="v$.cep.$error"
                >CEP é obrigatório</small
              >
            </div>
            <div class="field col-12 mt-2">
              <div class="p-inputgroup">
                <span class="p-inputgroup-addon">
                  <i class="pi pi-key"></i>
                </span>
                <Password
                  v-model="senha"
                  @input="v$.senha.$touch()"
                  placeholder="Senha"
                >
                  <template #header>
                    <h6>Escolha a senha</h6>
                  </template>
                  <template #footer="sp">
                    {{ sp.level }}
                    <Divider />
                    <p class="mt-2">Sugestões</p>
                    <ul class="pl-2 ml-2 mt-0" style="line-height: 1.5">
                      <li>Pelo menos uma minúscula</li>
                      <li>Pelo menos uma maiúscula</li>
                      <li>Pelo menos um numérico</li>
                      <li>Mínimo de 8 caracteres</li>
                    </ul>
                  </template>
                </Password>
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
                Já possui conta ?
                <router-link to="/login">Login</router-link></strong
              >
            </div>
          </div>
        </template>
      </Card>
    </div>
  </div>
</template>

<script>
import useVuelidate from '@vuelidate/core'
import { required } from '@vuelidate/validators'
import service from './service'

export default {
  setup () {
    return { v$: useVuelidate() }
  },
  data () {
    return {
      email: '',
      senha: '',
      usuario: '',
      cpf: '',
      cep: ''
    }
  },
  validations () {
    return {
      email: { required },
      senha: { required },
      usuario: { required },
      cpf: { required },
      cep: { required }
    }
  },
  methods: {
    send () {
      this.v$.$touch()
      if (this.v$.$invalid) return
      this.$store.dispatch('addRequest')
      this.cadastrar()
    },

    cadastrar () {
      const usuario = {
        email: this.email,
        senha: this.senha,
        usuario: this.usuario,
        cpf: this.cpf,
        cep: this.cep
      }

      service
        .cadastrar(usuario)
        .then(() => {
          this.$toast.add({
            severity: 'success',
            summary: 'Sucesso',
            detail: 'Usuario cadastrado!',
            life: 3000
          })
          this.$router.push('/login')

          this.$store.dispatch('removeRequest')
        })
        .catch((e) => {
          this.$toast.add({
            severity: 'error',
            summary: 'Error',
            detail: `${e.response.data.descricao}`,
            life: 3000
          })
          this.$store.dispatch('removeRequest')
        })
    }
  }
}
</script>

<style></style>

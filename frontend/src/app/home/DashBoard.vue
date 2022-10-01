<template>
  <div>
    <Menubar>
      <template #start>
        <img
          alt="logo"
          src="https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png"
          height="40"
          class="mr-2"
        />
      </template>
      <template #end>
        <div class="container px-4 text-center">
          <div class="row gx-4">
            <div class="col form-control">
              <i class="pi pi-user">{{ usuario }}</i>
            </div>
            <div class="col">
              <Button
                label="Sair"
                icon="pi pi-arrow-circle-right"
                iconPos="right"
                class="p-button-danger p-button-sm"
                @click="logout"
              />
            </div>
          </div>
        </div>
      </template>
    </Menubar>
  </div>
</template>

<script>
export default {
  data () {
    return {
      usuario: ''
    }
  },
  mounted () {
    this.buscarUsuario()
  },
  methods: {
    buscarUsuario () {
      this.usuario = localStorage.getItem('usuario')
    },
    logout () {
      localStorage.removeItem('token')
      this.$toast.add({
        severity: 'success',
        summary: 'Sucesso',
        detail: 'Logout feito com sucesso!',
        life: 3000
      })

      this.$router.push('/login')
    }
  }
}
</script>

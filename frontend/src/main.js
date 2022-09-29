/* eslint-disable vue/multi-word-component-names */

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import PrimeVue from 'primevue/config'
import InputText from 'primevue/inputtext'
import Card from 'primevue/card'
import Button from 'primevue/button'

const app = createApp(App)

app.use(store)
app.use(router)
app.use(PrimeVue)

// components prime
app.component('InputText', InputText)
app.component('Card', Card)
app.component('Button', Button)

app.mount('#app')

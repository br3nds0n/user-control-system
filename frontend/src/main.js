/* eslint-disable vue/multi-word-component-names */

import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router'
import store from './store'

import PrimeVue from 'primevue/config'
import InputText from 'primevue/inputtext'
import Card from 'primevue/card'
import Button from 'primevue/button'
import Message from 'primevue/message'
import TabMenu from 'primevue/tabmenu'
import ToastService from 'primevue/toastservice'
import Toast from 'primevue/toast'

import LoadingComponet from './components/LoadingComponent.vue'

import { library } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon, FontAwesomeLayers, FontAwesomeLayersText } from '@fortawesome/vue-fontawesome'
library.add(fas)

const app = createApp(App)

app.use(store)
app.use(router)
app.use(PrimeVue)
app.use(ToastService)

// components prime
app.component('InputText', InputText)
app.component('Card', Card)
app.component('Button', Button)
app.component('Message', Message)
app.component('TabMenu', TabMenu)
app.component('Toast', Toast)

// components app
app.component('LoadingComponet', LoadingComponet)

app.component('font-awesome-icon', FontAwesomeIcon)
app.component('font-awesome-layers', FontAwesomeLayers)
app.component('font-awesome-layers-text', FontAwesomeLayersText)

app.mount('#app')

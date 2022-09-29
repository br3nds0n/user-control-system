import Axios from 'axios'

const urlBase = 'http://localhost:5000/api/login'

export default {
  login (credenciais) {
    return Axios.post(urlBase, credenciais)
  }
}

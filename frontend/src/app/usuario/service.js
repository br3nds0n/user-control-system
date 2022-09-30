import Axios from 'axios'

const urlBase = 'http://localhost:5000/api/cadastrar'

export default {
  cadastrar (usuario) {
    return Axios.post(urlBase, usuario)
  }
}

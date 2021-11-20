import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'
import axios from "axios";
import './mock/'

const app = createApp(App)
installElementPlus(app)
app.config.globalProperties.$http = axios

app.use(store).use(router).mount('#app')
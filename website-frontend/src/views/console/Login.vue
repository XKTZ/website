<template>
  <div class="login-panel">
    <div class="title">
      LOGIN
    </div>

    <el-input v-model="email" placeholder="Email" class="data-input"/>
    <el-input v-model="password" placeholder="Password" class="data-input" show-password/>
    <el-button type="primary" class="data-input" @click="login()">Login</el-button>

    <div class="data-output">{{ msg }}</div>
  </div>
</template>

<script>
import {ref} from "vue";
import axios from "axios";

export default {
  name: "login",
  setup() {
    const email = ref("");
    const password = ref("");
    const msg = ref("");
    const login = ref(async function () {
      msg.value = ""
      let ret = (await axios.post(`/login/byEmail?email=${email.value}&password=${password.value}`)).data;
      msg.value = ret.message
    })
    return {email, password, login, msg};
  }
}
</script>

<style scoped>
.login-panel {
  margin-top: 10%;
}

.title {
  margin-top: 3%;
  margin-bottom: 3%;
  font-style: normal;
  font-size: 300%;
}

.data-input {
  margin-bottom: 2%;
  width: 100%;
}

.data-output {
  width: 100%;
}
</style>
<template>
  <control-panel v-if="enabled">
  </control-panel>
</template>

<script>

import {ref} from "vue";
import ControlPanel from "@/views/console/ControlPanel";
import axios from "axios";

export default {
  name: "Control",
  components: {
    ControlPanel
  },
  setup() {

    const enabled = ref(false);

    async function run() {
      enabled.value = (await axios.get("/console/admin/")).data;
      if (!enabled.value) {
        alert("You have not logged in or you are not admin, please try to login");
      }
    }

    run();

    return {enabled};
  }
}
</script>

<style scoped>

</style>
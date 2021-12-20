<template>
  <div ref="card">
    <el-card body-style="width: 180px; height: 160px">
      <!--the header-->
      <template #header>
        <div class="project-item-title">
          <!-- link -->
          <el-link :href="url">
            <span class="project-item-title-text">{{ name }}</span>
          </el-link>
        </div>
      </template>
      <!--the desc-->
      <div class="project-item-desc" :style="`width: ${cardWidth}; `">
        {{ desc }}
      </div>
    </el-card>
  </div>
</template>

<script>
import {onMounted, ref} from "vue";

export default {
  name: "ProjectItem",
  props: [
    "url",
    "name",
    "desc"
  ],
  setup() {
    const card = ref(null);
    const cardWidth = ref("0px");
    onMounted(() => {
      cardWidth.value = `${card.value.clientWidth * .8}px`
    })
    return {card, cardWidth}
  }
}
</script>

<style scoped>
.project-item-title {
}

.project-item-title-text {
  text-align: center;
  font-size: 200%;
}

.project-item-desc {
  font-size: 125%;
  text-align: justify;
}
</style>
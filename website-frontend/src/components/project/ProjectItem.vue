<template>
    <el-card :body-style="cardStyle">
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
      <div class="project-item-desc">
        {{ desc }}
      </div>
    </el-card>
</template>

<script>
import {onMounted, ref} from "vue";

export default {
  name: "ProjectItem",
  props: [
    "url",
    "name",
    "desc",
    "projectContainer"
  ],
  setup(props) {
    const cardStyle = ref ({
      width: "100%"
    });
    onMounted(() => {
      cardStyle.value.width = `${props.projectContainer.value.clientWidth * .85}px`;
    })
    return {cardStyle}
  }
}
</script>

<style scoped>
.project-item-title {
  text-align: left;
}

.project-item-title-text {
  font-size: 150%;
}

.project-item-desc {
  font-size: 125%;
  text-align: justify;
}
</style>
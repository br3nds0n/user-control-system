<template>
  <loading-componet v-if="$store.getters.isLoading"></loading-componet>
  <Toast :baseZIndex="1000" />
  <router-view></router-view>
</template>

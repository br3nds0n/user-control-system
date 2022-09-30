<template>
  <div>
      <div class="card">
          <TabMenu :model="items" />
          <router-view/>
      </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      active: 3,
      items: [
        {
          label: 'Home',
          icon: 'pi pi-fw pi-home',
          to: '/'
        },
        {
          label: 'Calendar',
          icon: 'pi pi-fw pi-calendar',
          to: '/calendar'
        },
        {
          label: 'Edit',
          icon: 'pi pi-fw pi-pencil',
          to: '/edit'
        },
        {
          label: 'Documentation',
          icon: 'pi pi-fw pi-file',
          to: '/documentation'
        },
        {
          label: 'Settings',
          icon: 'pi pi-fw pi-cog',
          to: '/settings'
        }
      ]
    }
  }
}
</script>

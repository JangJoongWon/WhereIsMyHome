<template>
  <div>
    <house-search></house-search>
    <house-map></house-map>
    <house-deal-list></house-deal-list>
  </div>
</template>

<script>
import HouseSearch from "@/components/house/HouseSearch";
import HouseMap from "@/components/house/HouseMap";
import HouseDealList from "@/components/house/HouseDealList";

export default {
  name: 'AppHouse',
  components: {
    HouseSearch,
    HouseMap,
    HouseDealList,
  }
}
</script>

<style>

</style>
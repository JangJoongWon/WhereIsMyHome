<template>
  <div>
    <div id="map"></div>
    <div v-if="this.houses && this.houses.legnth == 0">아파트 정보가 없습니다.</div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

const houseStore = "houseStore";

export default {
    name: 'HouseMap',
    data() {
      return {
        map: null,
      };
    },
    mounted() {
      if (window.kakao && window.kakao.maps) {
        this.loadMap();
      } else {
        this.loadScript();
      }
    },
    computed: {
      ...mapState(houseStore, ["houses"]),
    },
    watch: {
      houses() {
        if(this.houses && this.houses.length != 0) {
          var sumLat = 0, sumLng = 0;
          for(var idx3 = 0; idx3 < this.houses.length; idx3++) {
            sumLat += this.houses[idx3].lat;
            sumLng += this.houses[idx3].lng;
          }
          var centerLat = sumLat / this.houses.length;
          var centerLng = sumLng / this.houses.length;

          var moveLatLon = new window.kakao.maps.LatLng(centerLat, centerLng);
          this.map.setCenter(moveLatLon);

          var positions = [];
          for(var idx = 0; idx < this.houses.length; idx++) {
            var position = {
              content: `<div>${this.houses[idx].apartmentName}</div>`,
              latlng: new window.kakao.maps.LatLng(this.houses[idx].lat, this.houses[idx].lng),
            };
            positions.push(position);
          }
          
          for(var idx2 = 0; idx2 < positions.length; idx2++) {
            var marker = new window.kakao.maps.Marker({
              map: this.map,
              position: positions[idx2].latlng,
              clickable: true,
            });
            var infowindow = new window.kakao.maps.InfoWindow({
              content: positions[idx2].content,
            })
            window.kakao.maps.event.addListener(marker, 'mouseover', this.makeOverListener(this.map, marker, infowindow));
            window.kakao.maps.event.addListener(marker, 'mouseout', this.makeOutListener(infowindow));

            const count = idx2;
            window.kakao.maps.event.addListener(marker, 'click', () => this.searchHouseDeal(count));
          }
        } else {
          this.loadMap();
        }
      }
    },
    methods: {
      ...mapActions(houseStore, ["getHouseDealList"]),
      loadMap() {
        const container = document.getElementById("map");
        const options = {
          center: new window.kakao.maps.LatLng(33.450701, 126.570667),
          level: 3,
        };

        this.map = new window.kakao.maps.Map(container, options);
      },
      loadScript() {
        const script = document.createElement("script");
        const APP_KEY = "35783ac070c2d51d48a95de3a0b6320f";
        script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${APP_KEY}&autoload=false`;
        script.onload = () => window.kakao.maps.load(this.loadMap);

        document.head.appendChild(script);
      },
      makeOverListener(map, marker, infowindow) {
          return function() {
              infowindow.open(map, marker);
          };
      },
      makeOutListener(infowindow) {
          return function() {
              infowindow.close();
          };
      },
      searchHouseDeal(idx) {
        this.getHouseDealList(this.houses[idx].aptCode);
      },
    },
}
</script>

<style scoped>
#map {
  width: 100%;
  height: 400px;
}
</style>
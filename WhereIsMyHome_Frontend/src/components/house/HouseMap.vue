<template>
  <div class="housemap">
    <div class="address" v-show="this.dong">
      {{ this.sido }} {{ this.gugun }} {{ this.dong }}
    </div>

    <div id="map" style="font-size: 15px"/>

    <house-favorite-button v-if="this.markerIdx != null && this.houseDeals && this.houseDeals.length != 0" :houseIdx="markerIdx" />

    <b-icon v-if="this.dong && this.houseDeals && this.houseDeals.length != 0 && this.markerIdx == null" icon="star-fill" variant="warning" font-scale=2 />

    <span v-if="this.markerIdx != null && this.dong && this.houseDeals && this.houseDeals.length != 0">
      {{ this.houses[markerIdx].apartmentName }}
    </span>

    <span v-if="this.apartmentName">
      {{ this.apartmentName }}
    </span>

    <span v-if="this.dong && this.houses && this.houses.length == 0">
      아파트 정보가 없습니다.
    </span>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions } from "vuex";
import HouseFavoriteButton from "./HouseFavoriteButton.vue";

const houseStore = "houseStore";
const userStore = "userStore";

export default {
  name: 'HouseMap',
  data() {
    return {
      map: null,
      markerIdx: null,
    };
  },
  components: {
    HouseFavoriteButton,
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
    } else {
      this.loadScript();
    }
  },
  destroyed() {
    this.CLEAR_SIDO();
    this.CLEAR_GUGUN();
    this.CLEAR_DONG();
    this.CLEAR_APTNAME();
  },
  computed: {
    ...mapState(houseStore, ["sido", "gugun", "dong", "apartmentName", "houses", "houseDeals"]),
    ...mapState(userStore, ["userid"]),
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
    },
  },
  methods: {
    ...mapActions(houseStore, ["getHouseDealList"]),
    ...mapMutations(houseStore, ["CLEAR_SIDO", "CLEAR_GUGUN", "CLEAR_DONG", "CLEAR_APTNAME"]),
    loadMap() {
      const container = document.getElementById("map");
      if(container == null) {
        return;
      }
      const options = {
        center: new window.kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
      };

      this.map = new window.kakao.maps.Map(container, options);
    },
    loadScript() {
      const script = document.createElement("script");
      const APP_KEY = process.env.VUE_APP_KAKAO_KEY;
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
    searchHouseDeal(idx3) {
      this.CLEAR_APTNAME();

      this.getHouseDealList(this.houses[idx3].aptCode);
      this.markerIdx = idx3;
    },
  },
}
</script>

<style scoped>
#map {
  width: 500px;
  height: 400px;
}

.address {
  height: 40px;
}

.housemap {
  font-weight: bold;
  font-size: 20px;
}
</style>
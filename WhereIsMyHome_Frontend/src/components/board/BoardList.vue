<template>
    <div>
        <table>
            <thead>
                <tr>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                    <th>4</th>
                    <th>5</th>
                    <th>6</th>
                    <th>7</th>
                    <th>8</th>
                </tr>
            </thead>
            <tbody>
                <board-list-items v-for="article in articles" :key="article.articleNo" :article="article"/>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from "axios";
import BoardListItems from "./BoardListItems";

export default {
    name: 'BoardList',
    components: {
        BoardListItems,
    },
    data() {
        return {
            articles: []
        };
    },
    created() {
        const API_URL = `http://localhost:8080/board/list`;

        axios({
            url: API_URL,
            method: "GET",
        }).then((response) => {
            this.articles = response.data;
        }).catch(() => {

        })
    },
    methods: {},
};
</script>

<style scoped></style>
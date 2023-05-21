<template>
    <tr>
        <td>{{ article.articleNo }}</td>
        <td>{{ article.id }}</td>
        <td>{{ article.name }}</td>
        <td>{{ article.subject }}</td>
        <td>{{ article.content }}</td>
        <td>{{ article.hit }}</td>
        <td>{{ article.registerTime }}</td>
        <td>{{ article.fileInfos }}</td>
    </tr>
</template>

<script>
export default {
    name: 'NoticeListItems',
    props: {
        article: Object
    },
    components: {},
    data() {
        return {
            message: '',
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped></style>
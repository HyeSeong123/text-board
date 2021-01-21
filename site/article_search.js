gsap.registerPlugin(ScrollTrigger);
const articleList = [];

$.get(
	'article_list.json',
	{},
	function(data) {
		data.forEach((row, index) => {

			const article = {
				num : row.num,
				regDate: row.regDate,
				writer: row.extra__writer,
				title: row.title,
				commentsCount : row.commentsCount,
				likes : row.likes,
				views : row.views
			};

			articleList.push(article);
		});
	},
	'json'
);

const articleListBoxVue = new Vue({
	el: "#article-list-wrap",
	data: {
		articleList: articleList,
		searchKeyword: ''
	},
	methods: {
		searchKeywordInputed: _.debounce(function(e) {
			this.searchKeyword = e.target.value;
		}, 500)
	},
	computed: {
		filterKey: function() {
			return this.searchKeyword.toLowerCase();
		},
		filtered: function() {
			if (this.filterKey.length == 0) {
				return this.articleList;
			}

			return this.articleList.filter((row) => {
				const keys = ['title', 'writer', 'regDate', 'commentsCount', 'views', 'likes', 'num'];

				const match = keys.some((key) => {
					if (row[key].toLowerCase().indexOf(this.filterKey) > -1) {
						return true;
					}
				});

				return match;
			});
		}
	}
});

var tl1 = gsap.timeline();

tl1.to('.search__balloon1', {
	x: 600,
	opacity: 1,
	duration: 1,
	ease : "none"
},"+=0.2");

tl1.to('.search__balloon2', {
	x: -600,
	opacity: 1,
	duration: 1,
	ease : "none"
});
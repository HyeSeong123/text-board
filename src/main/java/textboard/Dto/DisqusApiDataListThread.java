package textboard.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DisqusApiDataListThread {
	private int code;
	private List<Response> response;
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Response{
		private int likes;
		private int posts;
		public int getLikes() {
			return likes;
		}
		public void setLikes(int likes) {
			this.likes = likes;
		}
		public int getPosts() {
			return posts;
		}
		public void setPosts(int posts) {
			this.posts = posts;
		}
	}
}

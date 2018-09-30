package in.trysafe.trysafe;

public class PostViewModal {

    String postImage;
    String postName;
    String postAbout;
    String htmlLink;



    public PostViewModal(){

    }

    public PostViewModal(String postImage, String postName,String postAbout, String htmlLink ) {
        this.postImage = postImage;
        this.postName = postName;
        this.postAbout = postAbout;
        this.htmlLink = htmlLink;
    }

    public String getPostAbout() {
        return postAbout;
    }

    public void setPostAbout(String postAbout) {
        this.postAbout = postAbout;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getHtmlLink() {
        return htmlLink;
    }

    public void setHtmlLink(String htmlLink) {
        this.htmlLink = htmlLink;
    }
}

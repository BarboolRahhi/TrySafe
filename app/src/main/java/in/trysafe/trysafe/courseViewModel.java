package in.trysafe.trysafe;

public class courseViewModel {

    String courseName;
    String courseImage;
    String htmlLink;

    public String getHtmlLink() {
        return htmlLink;
    }

    public void setHtmlLink(String htmlLink) {
        this.htmlLink = htmlLink;
    }

    public courseViewModel(){

    }

    public courseViewModel(String courseName, String courseImage, String htmlLink) {
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.htmlLink = htmlLink;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }
}

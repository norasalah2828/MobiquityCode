package resources;

//This enum for endpoints
public enum APIResources {

    getUsersAPI("/users"),
    getPostsAPI("/posts"),
    getCommentsAPI("/comments");
    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }


}

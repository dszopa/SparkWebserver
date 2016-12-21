import repository.PostRepository;

/**
 * Created by Daniel Szopa on 12/21/2016.
 */
public class SparkTest {
    public static void main(String[] args) {

        PostRepository postRepository = new PostRepository();
        System.out.println(postRepository.getAllPosts());
//        Spark.before((request, response) -> {
//            boolean authenticated;
//            // ... Check if authenticated
//            authenticated = true;
//            if (!authenticated) {
//                Spark.halt(401, "You are not welcome here!");
//            }
//        });
//        Spark.get("/hello", (req, res) -> "Hello World!");
//        Spark.get("/test", (request, response) -> {
//
//        })
//        Spark.get("/stop", (request, response) -> {
//            Spark.stop();
//            return "Server has been stopped";
//        });
    }
}

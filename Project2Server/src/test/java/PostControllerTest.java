//
//
//import com.ex.Models.*;
//import com.ex.controller.*;
//import com.ex.persistence.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import javafx.geometry.Pos;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.servlet.ServletContext;
//
//import java.nio.charset.Charset;
//import java.sql.Date;
//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//
//@WebAppConfiguration
//@ContextConfiguration(locations = {"/test-application-context.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//public class PostControllerTest {
//
//  @Mock
//  UserRepo userRepo;
//
//  @Mock
//  PostRepo postRepo;
//
//  @Mock
//  FriendRepo friendRepo;
//
//  @Mock
//  CommentRepo commentRepo;
//
//  @Mock
//  LikeRepo likeRepo;
//
//  @Autowired
//  CommentController commentController;
//
//  @Autowired
//  LikeController likeController;
//
//  @Autowired
//  FriendController friendController;
//
//  @Autowired
//  UserController userController;
//
//  @Autowired
//  PostController postController;
//
//  @Autowired
//  WebApplicationContext wac;
//
//  private MockMvc mockMvc;
//
////    @Mock
////    private UserRepo userRepo;
////    User person = new User();
//
////    @InjectMocks
////    private UserController userController;
//
//  /**
//   * this creates a mock of our object post controller.
//   * @throws Exception
//   */
//  @Before
//  public void setup() {
//    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//  }
//
//
//  @Test
//  public void getInvalidPage() throws Exception {
//    MvcResult result = mockMvc.perform(get("/post/userPosts"))
//      .andDo(print())
//      .andExpect(status().isBadRequest())
//      .andReturn();
//  }
//
//
//  @Test
//  public void testLikeGet() throws Exception {
//    MvcResult result=mockMvc.perform(get("/like/get")
//      .contentType(MediaType.APPLICATION_JSON_VALUE)
//      .param("postId", "4"))
//      .andDo(print())
//      .andExpect(status().isOk())
//      .andReturn();
//  }
//  @Test
//  public void testFriendGetall() throws Exception {
//    User user = new User();
//    user.setId(3);
//    MvcResult result=mockMvc.perform(post("/friend/getall")
//      .contentType(MediaType.APPLICATION_JSON_VALUE)
//      .param("userId", "3"))
//      .andDo(print())
//      .andExpect(status().isOk())
//      .andReturn();
//  }
//  //make sure to use a combo of 3,7,6,2,1,32
//  @Test
//  public void shouldCreateNewFriend() throws Exception {
//    User user = new User();
//    User friend = new User();
//    friend.setId(32);
//    user.setId(7);
//    ResultActions result = mockMvc.perform(post("/friend/create")
//      .contentType(MediaType.APPLICATION_JSON_VALUE)
//      .content(asJsonString(new Friend(user,friend)))
//      .accept(MediaType.APPLICATION_JSON))
//      .andExpect(status().isOk());
//
//
//  }
//
//  @Test
//  public void shouldCreatePost() throws Exception{
//    User user = new User();
//    user.setId(3);
//    ResultActions result = mockMvc.perform(post("/post/create")
//      .contentType(MediaType.APPLICATION_JSON_VALUE)
//      .content(asJsonString(new Post(40, user, "test post", Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()),null, false)))
//      .accept(MediaType.APPLICATION_JSON))
//      .andExpect(status().isOk());
//  }
//
//  @Test
//  public void shouldCreateComment() throws Exception {
//    Comment comment= new Comment();
//    Post post = new Post();
//    User user = new User();
//    user.setId(3);
//    post.setId(4);
//    comment.setAssociatedPost(post);
//
//    ResultActions result = mockMvc.perform(post("/comment/create")
//      .contentType(MediaType.APPLICATION_JSON_VALUE)
//      .content(asJsonString(new Comment(1,post,user,"OMG THIS IS SO QUIRKY",Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()))))
//      .accept(MediaType.APPLICATION_JSON))
//      .andExpect(status().isOk());
//
//  }
//  //REMEMBER TO CHANGE EMAIL AND USERNAME
//  @Test
//  public void shouldCreateLike() throws Exception{
//    Post post = new Post();
//    User user = new User();
////    user.setPassword(45);
//    user.setUsername("sdfg");
//    user.setEmail("lol@hkjfsd.COM");
////    user.setDisplayName("lolol");
//    post.setId(4);
//    MvcResult result=mockMvc.perform(post("/like/create")
//      .contentType(MediaType.APPLICATION_JSON_VALUE)
//      .content(asJsonString(new Like(post,user))))
//      .andDo(print())
//      .andExpect(status().isOk())
//      .andReturn();
//
//  }
//  @Test
//  public void shouldCreateNewUser() throws Exception {
//    ResultActions result = mockMvc.perform(post("/user/create")
//      .contentType(MediaType.APPLICATION_JSON_VALUE)
//      .content(asJsonString(new User(12, "test@gmail.com", "usernametest", "display",4,false)))
//      .accept(MediaType.APPLICATION_JSON))
//      .andExpect(status().isOk());
//  }
//  public static String asJsonString( Object obj) {
//    try {
//      return new ObjectMapper().writeValueAsString(obj);
//    } catch (Exception e) {
//      throw new RuntimeException(e);
//    }
//  }
//
//  @Test
//  public void getUserPosts() throws Exception {
//    MvcResult result=mockMvc.perform(get("/post/all")
//      .contentType(MediaType.APPLICATION_JSON_VALUE).content("asdf"))
//      .andDo(print())
//      .andExpect(status().isOk())
//      .andReturn();
//
//  }
//
//  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
//  @Test
//  public void shouldLogin() throws Exception {
//
//    SignUpData user = new SignUpData();
//    user.setPassword("stfu");
//    user.setUsername("lol");
//    user.setEmail("lol@GFUS.COM");
//    user.setDisplayName("lolol");
//    ObjectMapper om = new ObjectMapper();
//    om.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
//    ObjectWriter ow= om.writer().withDefaultPrettyPrinter();
//    String requestJson = ow.writeValueAsString(user);
//    MvcResult result=mockMvc.perform(post("/user/login")
//      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
//      .andExpect(status().isOk())
//      .andReturn();
//  }
//
//}
//
//


import com.ex.Models.*;
  import com.ex.controller.*;
  import com.ex.persistence.*;
  import com.fasterxml.jackson.databind.ObjectMapper;
  import com.fasterxml.jackson.databind.ObjectWriter;
  import com.fasterxml.jackson.databind.SerializationFeature;
  import javafx.geometry.Pos;
  import org.junit.Assert;
  import org.junit.Before;
  import org.junit.Test;
  import org.junit.runner.RunWith;
  import org.mockito.InjectMocks;
  import org.mockito.Mock;
  import org.mockito.MockitoAnnotations;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.MediaType;
  import org.springframework.mock.web.MockServletContext;
  import org.springframework.test.context.ContextConfiguration;
  import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
  import org.springframework.test.context.web.WebAppConfiguration;
  import org.springframework.test.web.servlet.MockMvc;
  import org.springframework.test.web.servlet.MvcResult;
  import org.springframework.test.web.servlet.ResultActions;
  import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
  import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
  import org.springframework.test.web.servlet.setup.MockMvcBuilders;
  import org.springframework.web.context.WebApplicationContext;

  import javax.servlet.ServletContext;

  import java.nio.charset.Charset;
  import java.sql.Date;
  import java.sql.Time;
  import java.time.LocalDate;
  import java.time.LocalTime;

  import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
  import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
  import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
  import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebAppConfiguration
@ContextConfiguration(locations = {"/test-application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PostControllerTest {

  @Mock
  UserRepo userRepo;

  @Mock
  PostRepo postRepo;

  @Mock
  FriendRepo friendRepo;

  @Mock
  CommentRepo commentRepo;

  @Mock
  LikeRepo likeRepo;

  @Autowired
  CommentController commentController;

  @Autowired
  LikeController likeController;

  @Autowired
  FriendController friendController;

  @Autowired
  UserController userController;

  @Autowired
  PostController postController;

  @Autowired
  WebApplicationContext wac;

  private MockMvc mockMvc;

//    @Mock
//    private UserRepo userRepo;
//    User person = new User();

//    @InjectMocks
//    private UserController userController;

  /**
   * this creates a mock of our object post controller.
   * @throws Exception
   */
  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }


  @Test
  public void getInvalidPage() throws Exception {
    MvcResult result = mockMvc.perform(get("/post/userPosts"))
      .andDo(print())
      .andExpect(status().isBadRequest())
      .andReturn();
  }


  @Test
  public void testLikeGet() throws Exception {
    MvcResult result=mockMvc.perform(get("/like/get")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .param("postId", "4"))
      .andDo(print())
      .andExpect(status().isOk())
      .andReturn();
  }
  @Test
  public void testFriendGetall() throws Exception {
    User user = new User();
    user.setId(3);
    MvcResult result=mockMvc.perform(post("/friend/getall")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .param("userId", "3"))
      .andDo(print())
      .andExpect(status().isOk())
      .andReturn();
  }
  //make sure to use a combo of 3,7,6,2,1,32
  @Test
  public void shouldCreateNewFriend() throws Exception {
    User user = new User();
    User friend = new User();
    friend.setId(32);
    user.setId(2);
    ResultActions result = mockMvc.perform(post("/friend/create")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .content(asJsonString(new Friend(user,friend)))
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());


  }

  @Test
  public void shouldCreatePost() throws Exception{
    User user = new User();
    user.setId(3);
    ResultActions result = mockMvc.perform(post("/post/create")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .content(asJsonString(new Post(40, user, "test post", Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()),null, false)))
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }

  @Test
  public void shouldCreateComment() throws Exception {
    Comment comment= new Comment();
    Post post = new Post();
    User user = new User();
    user.setId(3);
    post.setId(4);
    comment.setAssociatedPost(post);

    ResultActions result = mockMvc.perform(post("/comment/create")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .content(asJsonString(new Comment(1,post,user,"OMG THIS IS SO QUIRKY",Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()))))
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());

  }
  //REMEMBER TO CHANGE EMAIL AND USERNAME
  @Test
  public void shouldCreateLike() throws Exception{
    Post post = new Post();
    User user = new User();
//    user.setPassword(45);
    user.setUsername("billiam");
    user.setEmail("lol@bill.com");
//    user.setDisplayName("lolol");
    post.setId(4);
    MvcResult result=mockMvc.perform(post("/like/create")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .content(asJsonString(new Like(post,user))))
      .andDo(print())
      .andExpect(status().isOk())
      .andReturn();

  }
  @Test
  public void shouldCreateNewUser() throws Exception {
    ResultActions result = mockMvc.perform(post("/user/create")
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .content(asJsonString(new User(12, "test@gmail.com", "usernametest", "display",4,false)))
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }
  public static String asJsonString( Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void getUserPosts() throws Exception {
    MvcResult result=mockMvc.perform(get("/post/all")
      .contentType(MediaType.APPLICATION_JSON_VALUE).content("asdf"))
      .andDo(print())
      .andExpect(status().isOk())
      .andReturn();

  }

  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
  @Test
  public void shouldLogin() throws Exception {

    SignUpData user = new SignUpData();
    user.setPassword("hah");
    user.setUsername("lol");
    user.setEmail("lol@GFUS.COM");
    user.setDisplayName("lolol");
    ObjectMapper om = new ObjectMapper();
    om.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
    ObjectWriter ow= om.writer().withDefaultPrettyPrinter();
    String requestJson = ow.writeValueAsString(user);
    MvcResult result=mockMvc.perform(post("/user/login")
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
      .andExpect(status().isOk())
      .andReturn();
  }

}



import com.fy.dao.BlogMapper;
import com.fy.pojo.Blog;
import com.fy.utils.IDUtils;
import com.fy.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void addBlog(){
        SqlSession sqlSession= MybatisUtils.getsqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java");
        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring");
        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务");
        blog.setViews(1000);
        blogMapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map=new HashMap();
        map.put("title","Java");
        map.put("author","狂神说");

        List<Blog> blogs = blogMapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map=new HashMap();
        map.put("title","微服务");
        //map.put("author","狂神说");
        map.put("views","9999");

        List<Blog> blogs = blogMapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map=new HashMap();
        //map.put("title","微服务2");
        map.put("author","狂神说2");
        map.put("id","4b99e57080324f348cf1851138dfa649");
        //map.put("views","9999");

        blogMapper.updateBlog(map);


        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession=MybatisUtils.getsqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map=new HashMap();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids",ids);



        List<Blog> blogs = blogMapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}

package com.zxw.mongodb;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.mongodb.client.result.UpdateResult;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * MongoDB 操作
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class MongodbApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
    }

    /**
     * 查询所有
     */
    @Test
    void testMongoDB() {
        List<Object> schoolUser = mongoTemplate.findAll(Object.class, "schoolUser");
        System.out.println(schoolUser);
    }

    @Test
    void test2() {
        Map<String, Object> map = new HashMap<>();
        map.put("content", "这门课收获很多的，值得推荐");
        map.put("time", DateUtil.parse("2020-02-07 10:12:22"));
        map.put("status", 0);
//        map.put("userId", "00000000001");
        map.put("nickName", "奥特曼");
        map.put("headImg", "https://s5.mogucdn.com/mlcdn/5abf39/180114_13a91k46hf2liikc1ikk4fhe1kkd2_132x132.jpg_48x48.webp");
        Map<String, Object> reply = new HashMap<>();
        List<Object> replies = new ArrayList<>();
        reply.put("content", "赞同你的说法");
        reply.put("time", DateUtil.parse("2020-08-26 12:10:22"));
        reply.put("to", "凹凸曼");
        reply.put("headImg", "https://s5.mogucdn.com/mlcdn/5abf39/180114_13a91k46hf2liikc1ikk4fhe1kkd2_132x132.jpg_48x48.webp");
        replies.add(reply);
        map.put("comment", replies);
        Map<String, Object> courseComment = mongoTemplate.insert(map, "courseComment");
        log.info(courseComment.toString());
    }

    /**
     * 首次评论
     */
    @Test
    void test3() {
        // 模拟首次评论
        Map<String, Object> courseComment = new HashMap<>();
        courseComment.put("_id", "course 的 id");
//        courseComment.put("commentCount", 1);
        List<Map<String, Object>> commentList = new ArrayList<>(); // 放置课程评论（一级评论）
        Map<String, Object> comment = new HashMap<>();
        comment.put("userId", "评论者的 userId");
        comment.put("nickName", "评论者的 nickName");
        comment.put("content", "评论的内容");
        comment.put("time", "评论的时间");
        comment.put("headImg", "评论者的头像链接");
        comment.put("status", "此条评论的状态");
//        comment.put("replyCount", 0);
        commentList.add(comment);
        courseComment.put("commentList", commentList);
        Map<String, Object> courseCom = mongoTemplate.insert(courseComment, "courseComment");
        log.info(courseCom.toString());
    }

    /**
     * 模拟非首次评论
     */
    @Test
    void test4() {
        Map<String, Object> comment = new HashMap<>();
        comment.put("userId", "评论者的 userId3");
        comment.put("nickName", "评论者的 nickName3");
        comment.put("content", "评论的内容3");
        comment.put("time", "评论的时间3");
        comment.put("headImg", "评论者的头像链接3");
        comment.put("status", "此条评论的状态3");
        Query query = new Query(Criteria.where("_id").is("course 的 id"));
        Update update = new Update();
        update.addToSet("commentList", comment);
        UpdateResult res = mongoTemplate.updateFirst(query, update, "courseComment");
        System.out.println(res);
        log.info(res.toString());
    }

    /**
     * 模拟对评论进行一级回复
     */
    public void test5() {
        List<Map<String, Object>> replies = new ArrayList<>();
        Map<String, Object> reply = new HashMap<>();
        reply.put("content", "一级回复模拟");
        reply.put("time", DateUtil.parse("2020-08-28 10:12:15"));
        reply.put("userId", "一级回复者的 userId");
        reply.put("nickName", "一级回复者的 nickName");
        reply.put("headImg", "一级回复者的头像连接");
        reply.put("status", "此条评论的状态");
    }

    /**
     * 查询评论是否存在
     */
    @Test
    public void test6() {

    }

    /* ************************************** 只有评论没有回复******************************* */
    /**
     * 查询某个课程的评论
     */
    @Test
    public void test7() {
        Query query = new Query(Criteria.where("_id").is("course 的 id"));
        Object courseComment = mongoTemplate.findOne(query, Object.class, "courseComment");
        if (ObjectUtil.isNull(courseComment)) {
            log.info(null);
        } else {
            log.info(courseComment.toString());
        }
    }

    /**
     * 添加评价（查询并修改）
     */
    @Test
    public void test8() {
        Query q = new Query(Criteria.where("_id").is("00000000000002"));
        Object courseComment = mongoTemplate.findOne(q, Object.class, "courseComment");
        if (ObjectUtil.isNull(courseComment)) { // 数据库没有相关课程的评论
            Map<String, Object> courseCom = new HashMap<>();
            courseCom.put("_id", "00000000000002");
            List<Map<String, Object>> commentList = new ArrayList<>();
            Map<String, Object> comment = new HashMap<>();
            comment.put("userId", "评论者的 userId4");
            comment.put("nickName", "评论者的 nickName3");
            comment.put("content", "评论的内容3");
            comment.put("time", "评论的时间3");
            comment.put("headImg", "评论者的头像链接3");
            comment.put("status", "此条评论的状态3");
            commentList.add(comment);
            courseCom.put("commentList", commentList);
            Map<String, Object> insert = mongoTemplate.insert(courseCom, "courseComment");
//            courseCom.
        } else {
            Map<String, Object> comment = new HashMap<>();
            comment.put("id", IdUtil.objectId());
            comment.put("userId", "255656164654");
            comment.put("nickName", "时间会给我答案");
            comment.put("content", "这套课程真的很不错，全网最佳的");
            comment.put("time", new Date());
            comment.put("headImg", "评论者的头像链接3");
            comment.put("status", 0); // 0-代表正常 -1：代表删除 -2-代表举报被禁
            Query query = new Query(Criteria.where("_id").is("00000000000002"));
            Update update = new Update().addToSet("commentList",comment);
            UpdateResult result = mongoTemplate.updateFirst(query, update, "courseComment");
            log.info(result.toString());
            if (result.getModifiedCount() > 0) {
                log.info("添加评价成功");
            } else {
                log.info("添加评价失败，请稍后再试");
            }
        }

    }

    /**
     * 添加评价
     */
    void test9() {
        // 添加评价
        Map<String, Object> comment = new HashMap<>();
        log.info("");
    }

    /**
     * 删除评价
     */
    @Test
    void test() {
        Query query = new Query(Criteria.where("_id").is("00000000000002").and("commentList.id").is("5f48cea9d64fc4025db76b9c"));
        Update update = new Update();
        update.set("commentList.$.status", -1);
        UpdateResult result = mongoTemplate.updateFirst(query, update, "courseComment");
        log.info(result.toString());
    }
}

package com.songjaewoo.scheduler;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.songjaewoo.model.dto.PostDto;
import com.songjaewoo.model.type.CategoryType;
import com.songjaewoo.service.PostService;
import com.songjaewoo.util.CommonUtil;

@RestController
public class ScheduleController {
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/sss", method = RequestMethod.GET)
	public void index() {
		try {
			String search = "gif";
			crawlingPostListBySearch(search, "ilbe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crawlingPostListBySearch(String search, String type) throws Exception {
		if (type.equals("ilbe")) {
			String getUrl = "http://www.ilbe.com/?mid=jjal&search_target=title&search_keyword=" + search;
			Document doc = Jsoup.connect(getUrl).get();
			
			Elements linkUrlEle = doc.select(".boardList tr .title a");
			
			for (Element e : linkUrlEle) {
				String linkUrl = e.attr("href");
				
				Map<String, String> params = CommonUtil.getQueryMap(linkUrl);
				String idx = params.get("document_srl");
				String crawlingUrl = "http://www.ilbe.com/" + idx;
				
				crawlingPostDetail(crawlingUrl, type);
			}
		}
	}
	
	public void crawlingPostDetail(String url, String type) throws Exception {
		if (type.equals("ilbe")) {
			Document doc = Jsoup.connect(url).get();
			
			Elements titleEle = doc.select(".title h1 a");
			Elements contentEle = doc.select(".xe_content #copy_layer_1");
			Elements createdDateEle = doc.select(".dateAndCount .date");
					
			if (!titleEle.isEmpty() && !contentEle.isEmpty()) {
					String title = titleEle.get(0).text();
					String content = contentEle.get(0).html();
					
					PostDto.Create postDto = new PostDto.Create();
					postDto.setTitle(title);
					postDto.setDescription(content);
					postDto.setCategoryId(Long.valueOf(CategoryType.crawling.seq));
					
					postService.createPost(postDto);
			}
		}
	}
}

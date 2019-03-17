package com.jdc.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.shop.entity.Category;
import com.jdc.shop.entity.Item;

@LocalBean
@Stateless
public class ItemService {

	@PersistenceContext
	private EntityManager em;

	public List<Item> search(Category category, String name, String tag) {
		
		StringBuffer sb = new StringBuffer("select i from Item i where 1=1");
		Map<String, Object> params = new HashMap<>();
		
		if(null != category) {
			sb.append(" and i.category.id = :catId");
			params.put("catId", category.getId());
		}
		
		if(null != name && !name.isEmpty()) {
			sb.append(" and upper(i.name) like upper(:name)");
			params.put("name", name.concat("%"));
		}
		
		if(null != tag && !tag.isEmpty()) {
			sb.append(" and :tag member of i.tags");
			params.put("tag", tag);
		}

		TypedQuery<Item> query = em.createQuery(sb.toString(), Item.class);
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query.getResultList();
	}

	public void save(Item item) {
		em.merge(item);
	}
}

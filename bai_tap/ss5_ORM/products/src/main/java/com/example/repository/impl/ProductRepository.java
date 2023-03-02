package com.example.repository.impl;

import com.example.SessionUtil;
import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    public static List<Product> productList;

    @Override
    public List<Product> listAll(String productName) {
        Session session = null;
        List<Product> productList = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product where productName like concat('%',?1,'%') ").
                    setParameter(1, productName).getResultList();
        } catch (HibernateException e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(product);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product finById(Integer id) {
        Session session = null;
        Product product = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("from Product where id = :id").
                    setParameter("id", id).getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            Product product1 = finById(product.getId());
            product1.setProductName(product.getProductName());
            product1.setPrice(product.getPrice());
            product1.setStatus(product.getStatus());
            product1.setProduce(product.getProduce());
            session.update(product1);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            Product product = finById(id);
            session.remove(product);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        productList.remove(finById(id));
    }
}

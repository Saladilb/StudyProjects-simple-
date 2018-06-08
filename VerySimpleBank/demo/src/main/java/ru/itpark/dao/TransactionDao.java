package ru.itpark.dao;

import ru.itpark.models.Transaction;

import java.util.List;


public interface TransactionDao {
    void insert(Transaction transaction);

    Transaction getById(Integer id);

    List<Transaction> getAll();

    List<Transaction> getAllByIdBill(Integer idBill);

    List<Transaction> getAllByIdClient(Integer idClient);
}

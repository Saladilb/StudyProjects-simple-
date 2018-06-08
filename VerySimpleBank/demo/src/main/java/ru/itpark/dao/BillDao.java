package ru.itpark.dao;

import ru.itpark.models.Bill;

import java.util.List;


public interface BillDao {
    void insert(Bill bill);

    Bill getById(Integer id);

    List<Bill> getAll();

    List<Bill> getAllByIdClient(Integer idClient);

    List<Integer> getBillIdsByIdClient(Integer idClient);
}

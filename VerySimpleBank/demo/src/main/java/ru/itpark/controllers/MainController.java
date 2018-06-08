package ru.itpark.controllers;

import ru.itpark.implementations.BillDaoImpl;
import ru.itpark.implementations.ClientDaoImpl;
import ru.itpark.implementations.TransactionDaoImpl;
import ru.itpark.models.Client;
import ru.itpark.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itpark.models.Bill;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    ClientDaoImpl clientDaoImpl;
    @Autowired
    BillDaoImpl billDaoImpl;
    @Autowired
    TransactionDaoImpl transactionDaoImpl;

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннотации и настройки пути после деплоя) */
    @RequestMapping(value = "/")
    public ModelAndView allClients() {
        ModelAndView modelAndView = new ModelAndView();
        //получаем и передаём список клиентов
        List clients = clientDaoImpl.getAll();
        modelAndView.addObject("clientList", clients);
        //для формы добавления нового клиента
        modelAndView.addObject("clientModel", new Client());

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/add-client", method = RequestMethod.POST)
    public ModelAndView addClient(@ModelAttribute("clientModel") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        String result="";
        //Проверка на пустые поля
        if ((client.getSurname().trim().isEmpty() || client.getName().trim().isEmpty() ||
                client.getPatronymic().trim().isEmpty() || client.getAddress().trim().isEmpty())) {
            result="error";
        }
        else {
            //вставляем в БД нового клиента
            clientDaoImpl.insert(client);
            result="success";
        }
        modelAndView.addObject("resultString", result);
        //получаем и передаём список клиентов
        List clients = clientDaoImpl.getAll();
        modelAndView.addObject("clientList", clients);
        //для формы добавления нового клиента
        modelAndView.addObject("clientModel", new Client());

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/client-bills/{idClient}")
    public ModelAndView showClientBills(@PathVariable(value="idClient") Integer idClient) {
        ModelAndView modelAndView = new ModelAndView();
        //получаем и передаём инфу о клиенте
        Client client = clientDaoImpl.getById(idClient);
        modelAndView.addObject("client", client);
        //получаем и передаём список счетов
        List bills = billDaoImpl.getAllByIdClient(idClient);
        modelAndView.addObject("billList", bills);
        //для формы добавления нового счёта
        modelAndView.addObject("billModel", new Bill());
        //для списка id счетов
        modelAndView.addObject("listBillIds", billDaoImpl.getBillIdsByIdClient(idClient));
        //для формы добавления новой транзакции
        modelAndView.addObject("transactionModel", new Transaction());


        modelAndView.setViewName("clientBills");
        return modelAndView;
    }

    @RequestMapping(value = "/client-bills/{idClient}/add-bill", method = RequestMethod.POST)
    public ModelAndView addBill(@PathVariable(value="idClient") Integer idClient, /*@Valid*/ @ModelAttribute("billModel") Bill bill) {
        ModelAndView modelAndView = new ModelAndView();
        //получаем и передаём инфу о клиенте
        Client client = clientDaoImpl.getById(idClient);
        modelAndView.addObject("client", client);

        //вставляем в БД новый счёт
        billDaoImpl.insert(bill);
        this.showClientBills(idClient);
        //получаем и передаём список счетов
        List bills = billDaoImpl.getAllByIdClient(idClient);
        modelAndView.addObject("billList", bills);
        //для формы добавления нового счёта
        modelAndView.addObject("billModel", new Bill());

        //для списка id счетов
        modelAndView.addObject("listBillIds", billDaoImpl.getBillIdsByIdClient(idClient));

        //для формы добавления новой транзакции
        modelAndView.addObject("transactionModel", new Transaction());

        modelAndView.setViewName("clientBills");
        return modelAndView;
    }

    @RequestMapping(value = "/client-bills/{idClient}/add-transaction", method = RequestMethod.POST)
    public ModelAndView addTransaction(@PathVariable(value="idClient") Integer idClient,  @ModelAttribute("transactionlModel") Transaction transaction) {
        ModelAndView modelAndView = new ModelAndView();
        //получаем и передаём инфу о клиенте
        Client client = clientDaoImpl.getById(idClient);
        modelAndView.addObject("client", client);

        //получаем и передаём список счетов
        List bills = billDaoImpl.getAllByIdClient(idClient);
        modelAndView.addObject("billList", bills);
        //для формы добавления нового счёта
        modelAndView.addObject("billModel", new Bill());

        //для списка id счетов
        modelAndView.addObject("listBillIds", billDaoImpl.getBillIdsByIdClient(idClient));
        //для формы добавления новой транзакции
        modelAndView.addObject("transactionModel", new Transaction());

        modelAndView.setViewName("clientBills");
        return modelAndView;
    }
}

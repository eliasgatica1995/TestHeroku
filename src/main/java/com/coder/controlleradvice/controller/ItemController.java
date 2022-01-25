package com.coder.controlleradvice.controller;


import com.coder.controlleradvice.handle.ApiRestException;
import com.coder.controlleradvice.model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ItemController {

    ArrayList<Item> items= new ArrayList<Item>();
    int contadorId = 0  ;
    Logger logger = LogManager.getLogger(ItemController.class);

    @GetMapping("/example")
    public String getItemString() {
        logger.info("GET Request recibido string");
        return "Mensaje de prueba";
    }
    @GetMapping("/productos")
    public ArrayList<Item> getMensajesAll() throws ApiRestException {
        logger.info("GET Request recibido string");
        if (!(items.size() ==0))
            return items;
        else
            throw new ApiRestException("error: no hay productos cargados");
    }
    @PostMapping("/productos")
    public Item createItem(@RequestBody Item itemNuevo){
        logger.info("POST DE ITEM RECIBIDO");
        itemNuevo.setId(contadorId);

        items.add(new Item(contadorId,itemNuevo.getTitle(), itemNuevo.getPrice(),itemNuevo.getThumbnail()));
        contadorId++;
        return itemNuevo;
    }
    @GetMapping("/productos/{id}")
    public Item getItemById(@PathVariable int id) throws ApiRestException {
        logger.info("GET obtener mensaje por el id");


        if(!(id < items.size())||(id<0)) {
            throw new ApiRestException("error: producto no encontrado");
        }
        return new Item (items.get(id).getId(),items.get(id).getTitle(),items.get(id).getPrice(),items.get(id).getThumbnail());
    }
}

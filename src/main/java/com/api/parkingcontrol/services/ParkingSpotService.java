package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
/*TODO Criar interface para ParkingSpotService e em seguida
    uma classe com o conteúdo desta para implementar esta interface*/
@Service
public class ParkingSpotService {

    //Ponto de Injeção
    //Criado via construtor
    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }
}

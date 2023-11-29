package com.example.vinofind.service;
import com.example.vinofind.model.Winery;
import com.example.vinofind.repository.WineryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteToDB {
    @Autowired
    WineryRepository wineryRepository;


    public void writeToDb(String[] elements) {
         for (String element : elements) {
             String[] fields = element.split(",");
             Winery winery = new Winery(Long.parseLong(fields[0]), fields[3], Double.parseDouble(fields[2]), Double.parseDouble(fields[1]));
             if (wineryRepository.existsById(winery.getId())){
                 if (!winery.equals(wineryRepository.findById(winery.getId()).get())){
                     winery.update();
                     wineryRepository.save(winery);
                 }
             }
             else {
                 wineryRepository.save(winery);
             }
         }
    }
}

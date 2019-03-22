package hello;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import hello.Person;

import com.google.gson.*;
//import simple producer packages
import org.apache.kafka.clients.producer.Producer;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;


@RestController
public class PersonController
{
	@PostMapping(path="/add", produces = "application/json")
	public Object AddPerson(@RequestBody Person person) { //List<Object>
   /* return Arrays.asList(
    	person.getCode(),
        person.getName(),
        person.getAge(),
        person.getAddress());
        */

        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json);

        Properties prop=new Properties();
        prop.put("bootstrap.servers","localhost:9090,localhost:9091");
        prop.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        prop.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer(prop);

        ProducerRecord<String, String> rec = new ProducerRecord<String, String>("topic1", Integer.toString(person.getCode()),json);
        producer.send(rec);
        return person;
  }
  @RequestMapping("/get")
	public String AddPerson(@RequestParam(value="name", defaultValue="World") String name) {
    return "Response";
  }
}
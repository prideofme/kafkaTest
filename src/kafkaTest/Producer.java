package kafkaTest;

import java.io.IOException;
import java.util.Properties;

public class Producer1 {
	//定义topic
	private final static String TOPIC1 = "appreportdata_700091";
	public static void send() {
			Producer<String, Object> producer = null;
			Properties props = null;
			try {
	                        //初始化kafka配置信息
				props = PropertyUtils.load("producer_config.properties");
				producer = new KafkaProducer<>(props);
	//发送1万条数据
	for(int i=0;i++;i<=10000){
	producer.send(new ProducerRecord<String, Object>(TOPIC1, i));
	}
	 
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	try {
						producer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
	}

}

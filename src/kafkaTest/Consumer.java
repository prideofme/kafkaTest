package kafkaTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class Consumer1 {
	public static void getMessage() {
        //定义topic
     String TOPIC ="appreportdata_700091";
ConsumerRecords<String, Object> records = null;
     Properties props = null;
 KafkaConsumer<String, Object> consumer = null;
Properties props = null;
try {
	props = PropertyUtils.load("consumer_config.properties");
} catch (IOException e1) {
	e1.printStackTrace();
}
try {
	props = getProperties();
	consumer = new KafkaConsumer<>(props);
	// 订阅topic
	consumer.subscribe(Arrays.asList(TOPIC));
while (true) {
	try {
	//这里500是每隔500毫秒拉取一次数据，每次拉取的数据个数由kafka配置决定，默认拉取条数是500条，如果少于500条，每次拉取条数随机
		records = consumer.poll(500);
		count=records.count();
		System.err.println(count);
		
			for (ConsumerRecord<String, Object> record : records) {					
				String content= record.value();	
				//把接收到的数据进行处理
				offset = record.offset();
				System.out.println("接收数据条数"+offset);
			}					
	} catch (Exception e) {
		
	}
}
} catch (Exception e) {
	e.printStackTrace();
}

}

}

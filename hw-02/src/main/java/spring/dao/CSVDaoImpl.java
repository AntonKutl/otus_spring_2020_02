package spring.dao;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import spring.domane.Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class CSVDaoImpl implements CSVDao {

    private final MessageSource messageSource;
    private final String local;


    public CSVDaoImpl(MessageSource messageSource,@Value("${user.region}") String local) {
        this.messageSource = messageSource;
        this.local = local;
    }


    @Override
    public List<Questions> questions() throws IOException {
        InputStream in = getClass().getResourceAsStream(messageSource.getMessage("question.path",null, Locale.forLanguageTag(local)));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Questions> questionsList = new ArrayList<Questions>();

        while ((line = reader.readLine()) != null) {
            Questions questions = new Questions();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    questions.setQuestion(data);
                else if (index == 1)
                    questions.setAnswer(data);
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            index = 0;
            questionsList.add(questions);
        }

        reader.close();
        return questionsList;
    }
}

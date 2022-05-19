package edu.laverno.homework4.service;

import edu.laverno.homework4.domain.Answer;
import edu.laverno.homework4.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Scanner;

@Service
public class PollServiceImpl implements PollService {

    private final Question q;
    private final Answer a;

    @Autowired
    public PollServiceImpl(Question q, Answer a) {
        this.q = q;
        this.a = a;
    }

    @Override
    public void startPoll() {
        int correctAnswers = 0;
        Scanner scr = new Scanner(System.in);
        String name = scr.nextLine();
        System.out.println("Привет, " + name + "!\nТест:");

        for (int i = 0; i < q.getName().size(); i++) {
            printQuestion(i);
            System.out.print("Ваш ответ: ");
            if (checkAnswer(i, scr.nextInt()))
                correctAnswers++;
        }

        System.out.println("Итог теста: " + correctAnswers + "/" + q.getQuestions().size());
    }

    private void printQuestion(Integer index) {
        System.out.print(q.getName().get(index) + ": ");
        for (String question : q.getQuestions().get(index).split("\\.")) {
            System.out.print(question + " ");
        }
    }

    private boolean checkAnswer(Integer index, Integer answer) {
        return a.getAnswers().get(index).equals(
                Arrays.asList(q.getQuestions().get(index).split("\\.")).get(answer-1));
    }
}

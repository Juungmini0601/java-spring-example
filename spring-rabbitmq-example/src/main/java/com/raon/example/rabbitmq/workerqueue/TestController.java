package com.raon.example.rabbitmq.workerqueue;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {

	private final WorkQueueProducer producer;

	/**
	 * thread - 1 -> 11초
	 * thread - 2 -> 9초
	 * thread - 4 -> 8초
	 * thread - 5 -> 8초
	 * thread - 10 -> 6초
	 * thread - 20 -> 6초 Context Switching 때문인듯
	 * thread - 40 -> 9초
	 */
	@PostMapping("/work-queue")
	public String workQueue(
		@RequestParam String message,
		@RequestParam(defaultValue = "20") int threadCount
	) {

		final int TOTAL_MESSAGES = 100000;  // 총 메시지 수 10만개
		final int messagesPerThread = TOTAL_MESSAGES / threadCount;  // 스레드당 메시지 수

		if (TOTAL_MESSAGES % threadCount != 0) {
			throw new IllegalArgumentException("스레드 수는 100000의 약수여야 합니다.");
		}

		Thread[] threads = new Thread[threadCount];

		for (int t = 0; t < threadCount; t++) {
			final int start = t * messagesPerThread + 1;
			final int end = (t + 1) * messagesPerThread;
			threads[t] = Thread.startVirtualThread(() -> {
				for (int i = start; i <= end; i++) {
					producer.sendWorkQueue(message + i, 0);
				}
			});
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new RuntimeException("Thread was interrupted", e);
			}
		}

		return "OK";
	}

}

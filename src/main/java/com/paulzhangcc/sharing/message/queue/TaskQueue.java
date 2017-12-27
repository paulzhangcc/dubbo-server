package com.paulzhangcc.sharing.message.queue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class TaskQueue {

	private static Map<QueueEnum, LinkedBlockingQueue<Runnable>> queueMap = new HashMap<QueueEnum, LinkedBlockingQueue<Runnable>>();
	static {
		for (QueueEnum qe : QueueEnum.values()) {
			queueMap.put(qe, new LinkedBlockingQueue<Runnable>(100000));
		}
	}
	
	public static LinkedBlockingQueue<Runnable> getQueue(QueueEnum qe){
		return queueMap.get(qe);
	}
	
	public static Runnable get(QueueEnum qe){
		try {
			return queueMap.get(qe).take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void put(Runnable runnable, QueueEnum qe){
		try {
			queueMap.get(qe).put(runnable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean offer(Runnable runnable, QueueEnum qe){
		boolean b = false;
		try {
			b = queueMap.get(qe).offer(runnable, 10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	public static void putAll(List<Runnable> runnables, QueueEnum qe){
		queueMap.get(qe).addAll(runnables);
	}
}

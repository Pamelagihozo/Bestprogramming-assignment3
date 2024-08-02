1.	What is Logging
Logging is a practice of recording runtime information about an application's execution. This information is useful for debugging, monitoring, and auditing purposes.
2.	Why Logging is Important
•	Logs help developers identify and diagnose errors within an application. By providing detailed information about what went wrong, where and making it easier to fix bugs
•	By analyzing logs, developers can trace the sequence of events leading up to an issue, and helps to identify the root cause of problems
•	Logs provide insights into the performance and health of systems and applications by tracking resource usage, monitoring service uptime.
•	By regularly reviewing logs, administrators can detect warning signs of potential issues (like disk space running low or a spike in error rates) and address them before they become critical problems.
•	Logs can record access to systems, data, and resources, which is crucial for security audits and compliance with regulations. They help track unauthorized access attempts and identify security breaches.
•	In the event of a security incident, logs provide a historical record of events that can be analyzed to understand the nature and scope of the breach, helping to respond effectively.
•	Logs can be used to generate reports on system usage, performance metrics, and other operational aspects, which are useful for stakeholders and decision-makers.
•	By analyzing logs, developers and administrators can identify performance issues and optimize system performance, like identifying slow queries, resource contention, or inefficient code paths.

3.	What are Logging Levels
•	All : This includes all levels including custom levels
•	DEBUG: Indicates fine-grained informational events that are most useful to debug an application.
•	INFO: Indicates informational messages that highlight the progress of the application at coarse-grained level or the application’s operation
•	WARN: Indicates potential issues or non-critical problems.
•	ERROR: Indicates a problem that prevents certain functions from working properly but can still allow the application to continue running.
•	FATAL: Indicates very severe error events that will presumably lead the application to abort.
•	OFF: The highest possible rank and is intended to turn off logging.


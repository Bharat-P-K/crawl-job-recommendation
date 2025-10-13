## Job Recommendation Agent

In today's competitive job market, companies like training centers face challenges in efficiently matching skilled candidates (e.g., recent graduates or upskilled professionals) with relevant job opportunities. Manual matching processes are time-consuming, error-prone, and unable to scale as the number of candidates and job listings grows. For instance, a training center might train hundreds of individuals in skills like software development, data science, or cloud computing, but without an automated system, recruiters spend hours sifting through resumes and job postings, leading to delays, missed opportunities, and suboptimal matches.

The core problem is to build a **scalable job recommendation service** that automates candidate-job matching. This service should:

- Ingest candidate data (e.g., skills, experience, preferences) from a CRM system like Salesforce Agentforce.
- Store and query job listings efficiently.
- Use rule-based or simple algorithmic logic (e.g., skill keyword matching, location filtering, experience level scoring) to recommend jobs to candidates or vice versa.
- Handle increasing loads (e.g., thousands of queries per day) without performance degradation, ensuring low latency (<500ms per recommendation).
- Incorporate system design best practices for scalability, such as horizontal scaling, caching frequently accessed data, load balancing across instances, and fault tolerance.

### Tech Stack

- Java 17
- Spring Boot
- PostgreSQL
- Redis (optional)
- Salesforce API (mocked)

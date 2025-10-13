## Functional requirements

1. User should be able to see all the jobs that are present and click on a particular job
   a. IF pass --- see all the candidates
   b. IF fail --- Show proper message

### Actual Functional requirements

1. View All Jobs

User Story:
As a user, I want to view all available jobs so that I can explore potential opportunities.

Acceptance Criteria:

When I access the “All Jobs” view or call GET /jobs, I should see a list of job postings with title, description, skills, and location.

The list should be paginated (e.g., 10 jobs per page).

If no jobs are available, the system should display “No jobs available at the moment.”

If the API call fails, an appropriate error message should appear.

2. View Candidates for a Job

User Story:
As a recruiter, I want to view all candidates who match a selected job so that I can evaluate potential hires.

Acceptance Criteria:

When I click on a job, the system fetches candidates using GET /jobs/{jobId}/candidates.

If matching candidates exist, I should see their profiles (name, skills, experience, location).

If no candidates match, display “No matching candidates found.”

Handle system errors gracefully with an error message.

3. Add a New Job

User Story:
As an admin, I want to add new job listings so that they can be visible for matching and recommendations.

Acceptance Criteria:

When I send a POST /jobs request with valid payload (title, description, skills[], location, experience level), a new job should be created.

Response should return 201 Created with Job ID.

If required fields are missing, return 400 Bad Request.

If database insertion fails, return 500 Internal Server Error.

4. Add a New Candidate

User Story:
As a recruiter or integration system, I want to add a candidate profile so that they can be considered for job recommendations.

Acceptance Criteria:

When I send a POST /candidates request with valid payload (name, skills[], experience, location, preferences), a new candidate should be created.

Response should return 201 Created with Candidate ID.

If validation fails, return 400 Bad Request.

If API fails to communicate with Salesforce (in future integration), log the error and return 503 Service Unavailable.

5. Get Job Recommendations for a Candidate

User Story:
As a candidate, I want to receive recommended jobs so that I can apply to roles that match my skills and experience.

Acceptance Criteria:

When I call GET /recommend/{candidateId}, I should receive a ranked list of jobs with match scores.

Matching logic should consider:

Skill overlap (keyword or Jaccard similarity)

Experience level proximity

Location preference

The top 5 matches should be returned, sorted by score (descending).

If no matches are found, return an empty list with a message “No matching jobs found.”

API response time should be under 500ms for cached results.

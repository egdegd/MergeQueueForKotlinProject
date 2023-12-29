package com.example

data class Commits(
    val commits: List<Commit>
)
data class Commit(
    val url: String,
    val sha: String,
    val node_id: String,
    val html_url: String,
    val comments_url: String,
    val commit: CommitDetails,
    val author: GitHubUser,
    val parents: List<ParentCommit>,
    val committer: GitHubUser
)

data class CommitDetails(
    val url: String,
    val author: GitUser,
    val committer: GitUser,
    val message: String,
    val tree: Tree,
    val comment_count: Int,
    val verification: Verification
)

data class Tree(
    val url: String,
    val sha: String
)

data class Verification(
    val verified: Boolean,
    val reason: String,
    val signature: String?,
    val payload: String?
)

data class GitHubUser(
    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val events_url: String,
    val received_events_url: String,
    val type: String,
    val site_admin: Boolean
)

data class GitUser(
    val name: String,
    val email: String,
    val date: String
)

data class ParentCommit(
    val url: String,
    val sha: String,
    val html_url: String
)
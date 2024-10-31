import React, { useState } from 'react';
import { Code2, PlusCircle } from 'lucide-react';
import { posts as initialPosts } from './data';
import { Post } from './types';
import { PostCard } from './components/PostCard';
import { PostDetail } from './components/PostDetail';
import { CreatePost } from './components/CreatePost';

function App() {
  const [posts, setPosts] = useState<Post[]>(initialPosts);
  const [selectedPostId, setSelectedPostId] = useState<string | null>(null);
  const [showCreatePost, setShowCreatePost] = useState(false);

  const selectedPost = posts.find(post => post.id === selectedPostId);

  const handleCreatePost = (postData: { title: string; content: string; tags: string[] }) => {
    const newPost: Post = {
      id: (posts.length + 1).toString(),
      ...postData,
      author: 'Current User',
      date: new Date().toISOString().split('T')[0],
      imageUrl: 'https://images.unsplash.com/photo-1517694712202-14dd9538aa97',
      comments: []
    };
    setPosts([newPost, ...posts]);
    setShowCreatePost(false);
  };

  const handleAddComment = (postId: string, content: string) => {
    setPosts(posts.map(post => {
      if (post.id === postId) {
        const newComment = {
          id: `c${post.comments.length + 1}`,
          author: 'Current User',
          content,
          date: new Date().toISOString().split('T')[0],
          avatarUrl: 'https://images.unsplash.com/photo-1472099645785-5658abf4ff4e'
        };
        return {
          ...post,
          comments: [...post.comments, newComment]
        };
      }
      return post;
    }));
  };

  return (
    <div className="min-h-screen bg-gray-50">
      <header className="bg-white shadow-sm">
        <div className="max-w-7xl mx-auto px-4 py-6">
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-2">
              <Code2 className="w-8 h-8 text-blue-600" />
              <h1 className="text-2xl font-bold text-gray-900">
                Software Construction Blog
              </h1>
            </div>
            {!selectedPostId && (
              <button
                onClick={() => setShowCreatePost(true)}
                className="flex items-center gap-2 px-4 py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700"
              >
                <PlusCircle size={20} />
                Create Post
              </button>
            )}
          </div>
        </div>
      </header>

      <main className="max-w-7xl mx-auto px-4 py-8">
        {selectedPost ? (
          <PostDetail 
            post={selectedPost} 
            onBack={() => setSelectedPostId(null)}
            onAddComment={(content) => handleAddComment(selectedPost.id, content)}
          />
        ) : (
          <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
            {posts.map(post => (
              <PostCard 
                key={post.id} 
                post={post} 
                onClick={setSelectedPostId} 
              />
            ))}
          </div>
        )}
      </main>

      {showCreatePost && (
        <CreatePost
          onSubmit={handleCreatePost}
          onClose={() => setShowCreatePost(false)}
        />
      )}
    </div>
  );
}

export default App;